import request from '@/utils/request'
import { getToken } from '@/utils/auth';
const api_name = '/miuiver'
export default {
  getSignInHistory(page,limit,state) {
    return request({
      url: '/admin/miuiver/getSignInHistory',
      method: 'get',
      params: {
        page:page,
        limit:limit,
        state:state
      }
    })
  },

  addAccountNumber(acct,pwd) {
    return request({
      url: '/admin/miuiver/addAccountNumber',
      method: 'get',
      params:{
        acct:acct,
        pwd:pwd
      }
    })
  },
}
