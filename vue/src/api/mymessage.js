import request from '@/utils/request'
import { getToken } from '@/utils/auth';

const api_name = '/mymessage'

export default {
    getUserById() {
        return request({
          url: '/gateway/vue-admin-template/user/getUserById',
          method: 'get',
          params:{
            token:getToken(),
            id:sessionStorage.getItem("userId")
          }
        })
      },
      
      updateUserInfo(formData) {
        return request({
          url: '/gateway/vue-admin-template/user/updateUserInfo',
          method: 'put',
          data: formData
        //   data: {
        //     formData:formData,
        //     token: getToken()
        //   }
        
        })
      },
      changePwd(formData) {
        return request({
          url: '/gateway/vue-admin-template/user/changePwd',
          method: 'put',
          data: formData
        })
      },




    //   changePwd() {
    //       return request({
    //         url: '/gateway/vue-admin-template/user/changePwd',
    //         method: 'get',
    //         params:{
    //           token:getToken()
    //         }
    //       })
    //     }
}