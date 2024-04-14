import request from '@/utils/request'
import {
  getToken
} from '@/utils/auth';
const api_name = '/file_sharing'
export default {
  // String fileCode,String fileName,String fileText,String returnFileName,String fileUrl
  setFileOrMessage(fileCode, fileName, fileText, returnFileName, fileUrl) {
    return request({
      url: '/admin/file_sharing/setFileOrMessage',
      method: 'get',
      params: {
        fileCode: fileCode,
        fileName: fileName,
        fileText: fileText,
        returnFileName: returnFileName,
        fileUrl: fileUrl,
      }
    })
  },


  getFileInfoByCode(code) {
    return request({
      url: '/admin/file_sharing/getFileInfoByCode',
      method: 'get',
      params: {
        code: code,
      }
    })
  },

  panAddFile(fileName, fileUrl, fileSize) {
    return request({
      url: '/admin/file_sharing/panAddFile',
      method: 'get',
      params: {
        fileName: fileName,
        fileUrl: fileUrl,
        fileSize: fileSize,
      }
    })
  },

  panGetFileList(page, limit, sort, fileName) {
    return request({
      url: '/admin/file_sharing/panGetFileList',
      method: 'get',
      params: {
        page: page,
        limit: limit,
        sort: sort,
        fileName: fileName,
      }
    })
  },
  panDeleteFileById(fileId) {
    return request({
      url: '/admin/file_sharing/panDeleteFileById',
      method: 'get',
      params: {
        fileId: fileId,

      }
    })
  },
  panShareFile(fileId, fileShareDate) {
    return request({
      url: '/admin/file_sharing/panShareFile',
      method: 'get',
      params: {
        fileId: fileId,
        fileShareDate,
        fileShareDate

      }
    })
  },
  getPanFileByShareCode(shareCode) {
    return request({
      url: '/user/file_sharing/getPanFileByShareCode',
      method: 'get',
      params: {
        shareCode: shareCode,
      }
    })
  },
  webRegister(uname, pwd,age,sex,major,grade,email,phone) {
    return request({
      url: '/user/webRegister',
      method: 'get',
      params: {
        uname: uname,
        pwd: pwd,
		age:age,
		sex:sex,
		major:major,
		grade:grade,
		email:email,
		phone:phone,
      }
    })
  },

  addDownload(url) {
    return request({
      url: '/admin/file_sharing/addDownload',
      method: 'get',
      params: {
        url: url
      }
    })
  },

  getDownloadFileList(page) {
    return request({
      url: '/admin/file_sharing/getDownloadFileList',
      method: 'get',
      params: {
        page: page
      }
    })
  },
  delDownloadFile(id) {
    return request({
      url: '/admin/file_sharing/delDownloadFile',
      method: 'get',
      params: {
        id: id
      }
    })
  },
  setAutoUploadFile(id) {
    return request({
      url: '/admin/file_sharing/setAutoUploadFile',
      method: 'get',
      params: {
        id: id
      }
    })
  },

}
