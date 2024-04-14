import request from '@/utils/request'
import {
	getToken
} from '@/utils/auth';
const api_name = '/book'
export default {


	getUserListByConditionAxios(uname, email, major,page, limit) {
		return request({
			url: '/auth/getUserListByCondition',
			method: 'get',
			params: {
				username:uname, 
				email:email, 
				major:major,
				page: page,
				limit: limit,
				token: getToken(),
			}
		})
	},
	getUserListAxios(page, limit) {
		return request({
			url: '/auth/selectUserList',
			method: 'get',
			params: {
				page: page,
				limit: limit,
				token: getToken(),
			}
		})
	},
	updateUserAllInfoAxios(uid,uname, pwd,age,sex,major,grade,email) {
	  return request({
	    url: '/auth/updateUserAllInfo',
	    method: 'get',
	    params: {
			changeId:uid,
	      username: uname,
	      pwd: pwd,
		age:age,
		sex:sex,
		major:major,
		grade:grade,
		email:email,
		token: getToken(),
	    }
	  })
	},
	changePwdAxios(uid, newPwd) {
		return request({
				url: '/auth/updatePwdByUid',
				method: 'get',
				params: {
					uid: uid,
					pwd: newPwd,
					token: getToken(),
				}
			})
	},
	
	delUserAxios(uid){
	  return request({
	    url: '/auth/deleteUser',
	    method: 'get',
	    params: {
	      delUid: uid,
			token:getToken(),
	    }
	  })
	},
	
	getSortListAxios(page, limit) {
		return request({
			url: '/auth/book/sort/selectBookSortByPage',
			method: 'get',
			params: {
				page: page,
				limit: limit,
				token: getToken(),
			}
		})
	},
	getUserInfoByUidAxios(userId) {
		return request({
			url: '/auth/getUserInfoByUid',
			method: 'get',
			params: {
				userUId: userId,
				token: getToken(),
			}
		})
	},
	getUserInfoByTokenAxios() {
		return request({
			url: '/auth/getUserInfoByToken',
			method: 'get',
			params: {
				token: getToken(),
			}
		})
	},
	getSortOptionAxios() {
		return request({
			url: '/auth/book/sort/getSortOption',
			method: 'get',
			params: {

				token: getToken(),
			}
		})
	},
	
	
	addSortAxios(sortName) {
		return request({
			url: '/auth/book/sort/addBookSort',
			method: 'get',
			params: {
				sortName: sortName,
				token: getToken(),
			}
		})
	},
	
	changeSortAxios(id,sortName) {
		return request({
			url: '/auth/book/sort/updateBookSortById',
			method: 'get',
			params: {
				sid: id,
				sortName:sortName,
				token: getToken(),
			}
		})
	},
	delSortAxios(id) {
		return request({
			url: '/auth/book/sort/delBookSortById',
			method: 'get',
			params: {
				sid: id,
				token: getToken(),
			}
		})
	},
	
	getaddressListAxios(page, limit) {
		return request({
			url: '/auth/book/address/selectBookAddressByPage',
			method: 'get',
			params: {
				page: page,
				limit: limit,
				token: getToken(),
			}
		})
	},
	
	getaddressOptionAxios() {
		return request({
			url: '/auth/book/address/getAddressOption',
			method: 'get',
			params: {
				token: getToken(),
			}
		})
	},
	
	
	addAddressAxios(addressName) {
		return request({
			url: '/auth/book/address/addBookAddress',
			method: 'get',
			params: {
				addressName: addressName,
				token: getToken(),
			}
		})
	},
	
	changeAddressAxios(id,addressName) {
		return request({
			url: '/auth/book/address/updateBookAddressById',
			method: 'get',
			params: {
				sid: id,
				addressName:addressName,
				token: getToken(),
			}
		})
	},
	
	delAddressAxios(id) {
		return request({
			url: '/auth/book/address/delBookAddressById',
			method: 'get',
			params: {
				aid: id,
				token: getToken(),
			}
		})
	},
	
	addBookInfoAxios(bookName,sortId,rfidId,addressId,author,press,publicationDate,imageUrl,bookCount,isbn) {
		// String bookName,Integer sortId,String rfidId,Integer addressId
		return request({
			url: '/auth/book/info/addBookInfo',
			method: 'get',
			params: {
				bookName: bookName,
				sortId: sortId,
				rfidId: rfidId,
				addressId: addressId,
				author:author,
				press:press,
				publicationDate:publicationDate,
				imageUrl:imageUrl,
				bookCount:bookCount,
				isbn:isbn,
				token: getToken(),
			}
		})
	},
	updateBookInfoByIdAxios(bid,bookName,sortId,rfidId,addressId,author,press,publicationDate,imageUrl,bookCount) {
		// String bookName,Integer sortId,String rfidId,Integer addressId
		return request({
			url: '/auth/book/info/updateAllBookInfoById',
			method: 'get',
			params: {
				bid:bid,
				bookName: bookName,
				sortId: sortId,
				rfidId: rfidId,
				addressId: addressId,
				author:author,
				press:press,
				publicationDate:publicationDate,
				imageUrl:imageUrl,
				bookCount:bookCount,
				token: getToken(),
			}
		})
	},
	getBookInfoCreatListAxios(page, limit) {
		return request({
			url: '/auth/book/info/getBookInfoCreatList',
			method: 'get',
			params: {
				page: page,
				limit: limit,
				token: getToken(),
			}
		})
	},
	getBookInfoListAxios(page, limit) {
		return request({
			url: '/auth/book/info/selectBookInfoByPage',
			method: 'get',
			params: {
				page: page,
				limit: limit,
				token: getToken(),
			}
		})
	},
	getBookInfoByRfidAxios(addreddRfid) {
		return request({
			url: '/auth/book/info/getBookInfoByRfid',
			method: 'get',
			params: {
				rfid:addreddRfid,
				token: getToken(),
			}
		})
	},
	
	selectBookInfoConditionByPageAxios(bookName, author, press,page, limit) {
		return request({
			url: '/auth/book/info/selectBookInfoConditionByPage',
			method: 'get',
			params: {
				bookName:bookName, 
				author:author, 
				press:press,
				page: page,
				limit: limit,
				token: getToken(),
			}
		})
	},
	
	updateBookAddresssInfoByIdAxios(sid,addressId) {
		return request({
			url: '/auth/book/info/updateBookAddresssInfoById',
			method: 'get',
			params: {
				sid: sid,
				addressId: addressId,
				token: getToken(),
			}
		})
	},
	
	getBookInfoByIdAxios(bid) {
		return request({
			url: '/auth/book/info/getBookInfoById',
			method: 'get',
			params: {
				bid: bid,
				token: getToken(),
			}
		})
	},
	
	delBookInfo(aid) {
		return request({
			url: '/auth/book/info/delBookInfoById',
			method: 'get',
			params: {
				aid: aid,
				token: getToken(),
			}
		})
	},
	
	borrowBook(rfidId,endTime) {
		return request({
			url: '/auth/book/borrow/borrowBook',
			method: 'get',
			params: {
				rfidId: rfidId,
				endTime: endTime,
				token: getToken(),
			}
		})
	},
	
	selectBorrowList(page,limit) {
		return request({
			url: '/auth/book/borrow/selectBorrowList',
			method: 'get',
			params: {
				page: page,
				limit: limit,
				token: getToken(),
			}
		})
	},
	selectBorrowListByStatus(status,page,limit) {
		return request({
			url: '/auth/book/borrow/selectBorrowListByStatus',
			method: 'get',
			params: {
				status:status,
				page: page,
				limit: limit,
				token: getToken(),
			}
		})
	},
	
	returnBook(rfidId,raters) {
		return request({
			url: '/auth/book/borrow/returnBook',
			method: 'get',
			params: {
				rfidId: rfidId,
				raters: raters,
				token: getToken(),
			}
		})
	},
	getRfif() {
		return request({
			url: '/auth/book/rfid/getRfid',
			method: 'get',
			params: {
				token: getToken(),
			}
		})
	},
	getUserInfoChartAxios() {
		return request({
			url: '/auth/echart/getUserInfoChart',
			method: 'get',
			params: {
				token: getToken(),
			}
		})
	},
	getBookTypeInfoChartAxios() {
		return request({
			url: '/auth/echart/getBookTypeInfoChart',
			method: 'get',
			params: {
				token: getToken(),
			}
		})
	},
	getBookTypeInfoChartByUidAxios() {
		return request({
			url: '/auth/echart/getBookTypeInfoChartByUid',
			method: 'get',
			params: {
				token: getToken(),
			}
		})
	},
	getBootCountChartAxios() {
		return request({
			url: '/auth/echart/getBootCountChart',
			method: 'get',
			params: {
				token: getToken(),
			}
		})
	},
	getBootCountChartUserAxios() {
		return request({
			url: '/auth/echart/getBookCountByUid',
			method: 'get',
			params: {
				token: getToken(),
			}
		})
	},
}