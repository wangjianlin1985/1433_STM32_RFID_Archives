import request from '@/utils/request'
import { getToken } from '@/utils/auth';
const api_name = '/device'

export default {
  getOneSceneApi() {
    return request({
      url: '/gateway/device/getOneScene',
      method: 'get',
      params: {
        token: getToken()
      }
    })
  },

  getTwoSceneApi(id) {
    return request({
      url: '/gateway/device/getTwoScene',
      method: 'get',
      params: {
        id: id
      }

    })
  },
  // saveDevice
  saveDevice(formData) {
    return request({
      url: '/gateway/device/saveDevice',
      method: 'post',
      data: formData

    })
  },
  // fineDevice
  selectDevice(searchObj) {
    return request({
      url: '/gateway/device/selectDevice',
      method: 'post',
      data: searchObj

    })
  },
  // deleteDevice
  deleteDevice(id) {
    return request({
      url: '/gateway/device/deleteDevice',
      method: 'get',
      params: {
        token: getToken(),
        id: id
      }

    })
  },
  // selectDeviceById
  selectDeviceById(id) {
    return request({
      url: '/gateway/device/selectDeviceById',
      method: 'get',
      params: {
        id: id
      }

    })
  },
  // udateDevice
  udateDevice(formData) {
    return request({
      url: '/gateway/device/udateDevice',
      method: 'post',
      data: formData

    })
  },
  // selectIndexDeviceByUid
  selectIndexDeviceByUid() {
    return request({
      url: '/gateway/device/selectIndexDeviceByUid',
      method: 'get',
      params: {
        uid: sessionStorage.getItem("userId")
      }
    })
  },
  //addDeviceNode
  // Integer deviceId,String[] stringNode,String boolNode
  addDeviceNode(deviceId,stringNode,boolNode) {
    return request({
      url: '/gateway/device/addDeviceNode',
      method: 'post',
      data:{
        deviceId:deviceId,
        stringNode:stringNode,
        boolNode:boolNode,
      }
    })
  },
  // getDeviceNodeByDeviceId
  getDeviceNodeByDeviceId(deviceId){
    return request({
      url: '/gateway/device/getDeviceNodeByDeviceId',
      method: 'get',
      params: {
        deviceId:deviceId
      }

    })
  },
  // saveLimit 保存上下限
  saveLimit(limitParamId,upLimitValue,dowmLimitValue){
    return request({
      url: '/gateway/device/saveLimit',
      method: 'get',
      params: {
        limitParamId:limitParamId,
        upLimitValue:upLimitValue,
        dowmLimitValue:dowmLimitValue

      }

    })
  },
  //getLimitByParamId 获取上下限
  getLimitByParamId(limitParamId){
    return request({
      url: '/gateway/device/getLimitByParamId',
      method: 'get',
      params: {
        limitParamId:limitParamId,
      }

    })
  },
  //changeBoolNodeState 改变开关量的状态
  changeBoolNodeState(paramId){
    return request({
      url: '/gateway/device/changeBoolNodeState',
      method: 'get',
      params: {
        paramId:paramId,
      }

    })
  },
  //getEchartList 改变开关量的状态
  getEchartList(deviceId){
    return request({
      url: '/gateway/data/getEchartList',
      method: 'get',
      params: {
        deviceId:deviceId,
      }

    })
  },
  //获取该用户智慧大屏默认显示的设备信息
  getUserDeviceShow(){
    return request({
      url: '/gateway/device/getUserDeviceShow',
      method: 'get',
      params: {
        uid: sessionStorage.getItem("userId")
      }

    })
  },
  //修改该用户智慧大屏默认显示的设备信息
  setUserDeviceShow(deviceId){
    return request({
      url: '/gateway/device/setUserDeviceShow',
      method: 'get',
      params: {
        uid: sessionStorage.getItem("userId"),
        deviceId:deviceId
      }

    })
  },
  //查看设备秘钥
  getPskByDeviceId(deviceId){
    return request({
      url: '/gateway/device/getPskByDeviceId',
      method: 'get',
      params: {
        uid: sessionStorage.getItem("userId"),
        deviceId:deviceId
      }
    
    })
  }

}
