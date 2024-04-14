import router from './router'
import store from './store'
import {
  Message
} from 'element-ui'
import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css' // progress bar style
import {
  getToken
} from '@/utils/auth' // get token from cookie
import getPageTitle from '@/utils/get-page-title'

NProgress.configure({
  showSpinner: false
}) // NProgress Configuration

const whiteList = ['/login'] // no redirect whitelist

router.beforeEach(async (to, from, next) => {
  // start progress bar
  NProgress.start()
  // var routeTo404 = JSON.parse(sessionStorage.getItem('routerTo')) // 用于解决刷新404问题


  // set page title
  document.title = getPageTitle(to.meta.title)

  // determine whether the user has logged in
  const hasToken = getToken()

  if (hasToken) {
    // console.log('toPath',to.path);
    // console.log('indexOF',to.path.indexOf('/file_sharing/pan_get_file/'));
    if (to.path === '/login') {
      // console.log('不登录');
      // if is logged in, redirect to the home page
      next({
        path: '/'
      })
      NProgress.done()
    }
    // else if(to.path.indexOf('/file_sharing/pan_get_file/')>=0){
    //   next({ path: to.path })
    //   NProgress.done()
    // }
    else {
      const hasGetUserInfo = store.getters.name
      if (hasGetUserInfo) {
        next()
      } else {
        try {
          // get user info
          const {
            roles
          } = await store.dispatch('user/getInfo')
          console.log('role', roles);
          // generate accessible routes map based on roles
          const accessRoutes = await store.dispatch('permission/generateRoutes', roles)
          console.log('accessRoutes', accessRoutes);
          router.addRoutes(accessRoutes)
          // // dynamically add accessible routes


          if (to.redirectedFrom) {
            router.replace(to.redirectedFrom);
          } else {
           next()
          }
          // next()
        } catch (error) {
          // remove token and go to login page to re-login
          await store.dispatch('user/resetToken')
          Message.error(error || 'Has Error')
          next(`/login?redirect=${to.path}`)
          NProgress.done()
        }
      }
    }
  } else {
    /* has no token*/

    if (whiteList.indexOf(to.path) !== -1 || to.path.indexOf('/file_sharing/pan_get_file/') >= 0) {
      // in the free login whitelist, go directly
      next()
    } else {
      // other pages that do not have permission to access are redirected to the login page.
      next(`/login?redirect=${to.path}`)
      NProgress.done()
    }
  }
})

router.afterEach(() => {
  // finish progress bar
  // sessionStorage.setItem('routerTo', JSON.stringify(to))
  NProgress.done()
})
