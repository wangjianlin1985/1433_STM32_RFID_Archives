import request from '@/utils/request'
import { getToken } from '@/utils/auth';
const api_name = '/datamanage'

export default {
  // getDataByCondition
  getDataByCondition(formData) {
    return request({
      url: '/gateway/data/getDataByCondition',
      method: 'post',
      data: formData

    })
  },
  //   getDeviceInfoByUserId
  getDeviceInfoByUserId() {
    return request({
      url: '/gateway/device/getDeviceInfoByUserId',
      method: 'get',
      params: {
        uid: sessionStorage.getItem("userId")
      }

    })
  },
  // deleteById
  deleteById(id) {
    return request({
      url: '/gateway/data/deleteById',
      method: 'get',
      params: {
        dataId: id
      }

    })
  },
  // getUpDownByCondition
  getUpDownByCondition(formData) {
    return request({
      url: '/gateway/data/getUpDownByCondition',
      method: 'post',
      data: formData

    })
  },
  // deleteUpDownById
  deleteUpDownById(id) {
    return request({
      url: '/gateway/data/deleteUpDownById',
      method: 'get',
      params: {
        id: id
      }

    })
  },
  // getWarningByDeviceId
  getWarningByDeviceId(formData) {
    return request({
      url: '/gateway/data/getWarningByDeviceId',
      method: 'post',
      data: formData

    })
  },
  // deleteWarningById
  deleteWarningById(id,dataType) {
    return request({
      url: '/gateway/data/deleteWarningById',
      method: 'get',
      params: {
        id: id,
        dataType:dataType
      }

    })
  },
  // deleteAllDeviceDataByUId
  deleteAllDeviceDataByUId() {
    return request({
      url: '/gateway/data/deleteAllDeviceDataByUId',
      method: 'get',
      params: {
        uid: sessionStorage.getItem("userId")
      }

    })
  },
  // deleteAllUpDownDataByUId
  deleteAllUpDownDataByUId() {
    return request({
      url: '/gateway/data/deleteAllUpDownDataByUId',
      method: 'get',
      params: {
        uid: sessionStorage.getItem("userId")
      }

    })
  },
  // deleteAllWarningDataByUId
  deleteAllWarningDataByUId(temperatureMaxValue, humidityMaxValue) {
    return request({
      url: '/gateway/data/deleteAllWarningDataByUId',
      method: 'get',
      params: {
        uid: sessionStorage.getItem("userId"),
        temperatureMaxValue:temperatureMaxValue,
        humidityMaxValue:humidityMaxValue
      }

    })
  },

  // deleteDataByCondition
  deleteDataByCondition(formData) {
    return request({
      url: '/gateway/data/deleteDataByCondition',
      method: 'post',
      data: formData

    })
  },
  // getDeviceNodeListByDeviceId
  getDeviceNodeListByDeviceId(deviceId) {
    return request({
      url: '/gateway/data/getDeviceNodeListByDeviceId',
      method: 'get',
      params: {
        deviceId:deviceId
      }

    })
  },
}
