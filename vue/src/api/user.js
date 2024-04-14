import request from '@/utils/request'
import { getToken } from '@/utils/auth';

export function login(data) {
  return request({
    // url: '/vue-admin-template/user/login',

    url: '/user/login',
    method: 'get',
    withCredentials:false,
    params: {
      uname:data.uname,
      pwd:data.pwd
    }
  })
}

export function getInfo(token) {
  return request({
    // url: '/vue-admin-template/user/info',
    withCredentials:false,
    url: '/auth/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/auth/logout',
    method: 'post',
    params:{
      token:getToken()
    }
  })
}


export function webRegister(uname,pwd) {
  return request({
    url: '/user/webRegister',
    method: 'get',
    withCredentials:false,
    params: {
      uname:uname,
      pwd:pwd
    }
  })
}
