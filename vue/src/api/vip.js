import request from '@/utils/request'
import { getToken } from '@/utils/auth';
const api_name = '/vip'

export default {

    //   // selectDeviceById
    //   selectDeviceById(id) {
    //     return request({
    //       url: '/gateway/device/selectDeviceById',
    //       method: 'get',
    //       params: {
    //         id: id
    //       }

    //     })
    //   },
    //   // udateDevice
    //   udateDevice(formData) {
    //     return request({
    //       url: '/gateway/device/udateDevice',
    //       method: 'post',
    //       data: formData

    //     })
    //   },


    // getVipDate
    getVipDate() {
        return request({
            url: '/gateway/vip/getVipDate',
            method: 'get',
            params: {
                uid: sessionStorage.getItem("userId")
            }

        })
    },

    // buyVipMonth
    buyVipMonth() {
        return request({
            url: '/auth/recharge',
            method: 'get',
            params: {
                uid: sessionStorage.getItem("userId"),
                token:getToken(),
                sort:0,
                money:10
                
            }

        })
    },
    // buyVipYear
    buyVipYear() {
        return request({
            url: '/gateway/vip/buyVipYear',
            method: 'get',
            params: {
                uid: sessionStorage.getItem("userId")
            }

        })
    },

    // downloadData
    downloadData(formData) {
        return request({
            url: '/gateway/data/downloadData',
            method: 'post',
            data: formData

        })
    },

    //   getDownloadByUid

    getDownloadByUid(page, limit) {
        return request({
            url: '/gateway/data/getDownloadByUid',
            method: 'get',
            params: {
                uid: sessionStorage.getItem("userId"),
                page: page,
                limit: limit
            }

        })
    },
    // getDataByCondition
    getDataByCondition(formData) {
        return request({
            url: '/gateway/data/getEchertsData',
            method: 'post',
            data: formData

        })
    },
}
