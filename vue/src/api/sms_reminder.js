import request from '@/utils/request'
import { getToken } from '@/utils/auth';
const api_name = '/sms_reminder'
export default {
  addPhone(phone,cron) {
    return request({
      url: '/admin/SMSReminder/addPhone',
      method: 'get',
      params: {
        phone:phone,
        cron:cron,
      }
    })
  },
  getSMSList(page,size,phone) {
    return request({
      url: '/admin/SMSReminder/getSMSList',
      method: 'get',
      params: {
        phone:phone,
        page:page,
        size:size
      }
    })
  },
  openSMS(id) {
    return request({
      url: '/admin/SMSReminder/openSMS',
      method: 'get',
      params: {
        id:id
      }
    })
  },  
  closeSMS(id) {
    return request({
      url: '/admin/SMSReminder/closeSMS',
      method: 'get',
      params: {
        id:id
      }
    })
  },
  delQuartzById(id) {
    return request({
      url: '/admin/SMSReminder/delQuartzById',
      method: 'get',
      params: {
        id:id
      }
    })
  },
}
