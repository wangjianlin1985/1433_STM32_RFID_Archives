import { asyncRoutes, constantRoutes } from '@/router'

/**
 * Use meta.role to determine if the current user has permission
 * @param roles
 * @param route
 */
function hasPermission(roles, route) {


  console.log('roles',roles,'roter',route);
  let roles_name = roles


  if (route.meta && route.meta.roles) {
    // console.log('222');
    // roles.some(role => route.meta.roles.includes(role))
    // console.log('333');
    // return roles.some(role => route.meta.roles.includes(role))
    let i = 0
    for(i = 0;i<route.meta.roles.length;i++){
      let route_name = route.meta.roles[i]
      console.log('item',route.meta.roles[i],'flag',roles_name == route_name);
      if(roles_name == route_name){
        return true
      }
      // if(role == route.meta.roles[i]){
      //   return true
      // }
    }

    return false
  } else {
    return true
  }

}

/**
 * Filter asynchronous routing tables by recursion
 * @param routes asyncRoutes
 * @param roles
 */
export function filterAsyncRoutes(routes, roles) {
  const res = []



  routes.forEach(route => {
    const tmp = { ...route }
    if (hasPermission(roles, tmp)) {
      if (tmp.children) {
        tmp.children = filterAsyncRoutes(tmp.children, roles)
      }
      res.push(tmp)
    }
  })

  return res
}

const state = {
  routes: [],
  addRoutes: []
}

const mutations = {
  SET_ROUTES: (state, routes) => {
    state.addRoutes = routes
    state.routes = constantRoutes.concat(routes)
  }
}

const actions = {
  generateRoutes({ commit }, roles) {
    return new Promise(resolve => {
      let accessedRoutes
      if (roles.includes('admin')) {
        accessedRoutes = asyncRoutes || []
      } else {

        accessedRoutes = filterAsyncRoutes(asyncRoutes, roles)
      }
      commit('SET_ROUTES', accessedRoutes)
      resolve(accessedRoutes)
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
