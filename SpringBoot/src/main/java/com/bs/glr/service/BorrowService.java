package com.bs.glr.service;

import com.bs.glr.bean.BsBorrow;
import com.github.pagehelper.PageInfo;


public interface BorrowService {
    Integer insertBorrowBook(BsBorrow borrow);

    BsBorrow selectBorrowByUidAndrfidID(Integer uid, Integer bookId);

    Integer returnBook(Integer id);

    PageInfo<BsBorrow> selectBorrowList(Integer uid,Integer page,Integer limit);

    BsBorrow selectBorrowById(Integer borrowId);

    PageInfo<BsBorrow> selectBorrowListByStatus(String status, Integer uid, Integer page, Integer limit);
}
