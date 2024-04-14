package com.bs.glr.service.impl;

import com.bs.glr.bean.*;
import com.bs.glr.mapper.BsPhoneMapper;
import com.bs.glr.mapper.BsScoreMapper;
import com.bs.glr.mapper.BsTokenMapper;
import com.bs.glr.mapper.BsUserMapper;
import com.bs.glr.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Resource
    BsUserMapper userMapper;

    @Autowired
    BsTokenMapper tokenMapper;
    @Resource
    BsPhoneMapper phoneMapper;

    @Resource
    BsScoreMapper scoreMapper;


    @Override
    public List<BsUser> getUserByUname(String uname) {
        BsUserExample example = new BsUserExample();
        example.createCriteria().andUnameEqualTo(uname);
        List<BsUser> bsUsers = userMapper.selectByExample(example);
        return bsUsers;
    }

    @Override
    public void loginToken(String uuid,Integer uid) {
        BsToken token = new BsToken();
        token.setToken(uuid);
        BsTokenExample example = new BsTokenExample();
        example.createCriteria().andUidEqualTo(uid);
        tokenMapper.updateByExampleSelective(token,example);
    }



    @Override
    public String getUserNameByToken(String token) {
        BsTokenExample tokenExample = new BsTokenExample();
        tokenExample.createCriteria().andTokenEqualTo(token);
        List<BsToken> bsTokens = tokenMapper.selectByExample(tokenExample);
        if(bsTokens==null ||  bsTokens.size()<=0 ){
            return null;
        }
//        BsUserExample userExample = new BsUserExample();
//        userExample.createCriteria().andIdEqualTo(1);
        BsUser bsUsers = userMapper.selectByPrimaryKey(bsTokens.get(0).getUid());
        if(bsUsers == null ){
            return null;
        }

        return bsUsers.getUname();
    }

    @Override
    public Integer insertUser(String uname, String pwd) {

        BsUser user = new BsUser();
        user.setPwd(pwd);
        user.setUname(uname);
        user.setIdentity("1");
        userMapper.insertSelective(user);
        return user.getId();
    }

    @Override
    public void insertToken(Integer uid, String token) {
        BsToken bsToken = new BsToken();
        bsToken.setUid(uid);
        bsToken.setToken(token);
        tokenMapper.insertSelective(bsToken);
    }

    @Override
    public PageInfo<BsUser> selectUserListByPage(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        BsUserExample example = new BsUserExample();
        example.createCriteria().andIdentityEqualTo("1");
        example.setOrderByClause("book_count desc");
        List<BsUser> bsUsers = userMapper.selectByExample(example);
        PageInfo<BsUser> pageInfo = new PageInfo<>(bsUsers);
        return pageInfo;
    }

    @Override
    public void deleteUserById(Integer uid) {
        userMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public void updatePwdByUid(Integer uid, String pwd) {

        BsUser user = new BsUser();
        user.setId(uid);
        user.setPwd(pwd);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public BsUser selectUserByUid(Integer uid) {

        return userMapper.selectByPrimaryKey(uid);
    }

    @Override
    public BsUser getUserById(Integer uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    @Override
    public BsUser getUserByToken(String token) {
        BsTokenExample example = new BsTokenExample();
        example.createCriteria().andTokenEqualTo(token);
        List<BsToken> bsTokens = tokenMapper.selectByExample(example);
        if(bsTokens == null || bsTokens.size()<=0){
            return null;
        }

        BsUser userById = getUserById(bsTokens.get(0).getUid());
        return userById;
    }

    @Override
    public Integer insertUserBean(BsUser user) {
        userMapper.insertSelective(user);
        return user.getId();
    }

    @Override
    public PageInfo<BsUser> getUserListByCondition(String uname, String email, String major, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        BsUserExample example = new BsUserExample();
        BsUserExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(uname)){
            criteria.andUnameLike("%"+uname+"%");
        }
        if(!StringUtils.isEmpty(email)){
            criteria.andEmailLike("%"+email+"%");
        }
        if(!StringUtils.isEmpty(major)){
            criteria.andMajorLike("%"+major+"%");
        }
        criteria.andIdentityNotEqualTo("0");

        example.setOrderByClause("book_count desc");
        List<BsUser> bsUsers = userMapper.selectByExample(example);
        PageInfo<BsUser> pageInfo = new PageInfo<>(bsUsers);
        return pageInfo;
    }

    @Override
    public Integer updateUserAllInfo(BsUser user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void insertPhone(BsPhone bsPhone) {
        phoneMapper.insertSelective(bsPhone);
    }

    @Override
    public List<BsUser> getInactiveUser() {
        //不活跃
        BsUserExample bsUserExample = new BsUserExample();
        bsUserExample.createCriteria().andBookCountLessThan(10);
        return userMapper.selectByExample(bsUserExample);
    }

    @Override
    public List<BsUser> getCommonlyUser() {
        //一般
        BsUserExample bsUserExample = new BsUserExample();
        bsUserExample.createCriteria().andBookCountLessThanOrEqualTo(50).andBookCountGreaterThanOrEqualTo(10);
        return userMapper.selectByExample(bsUserExample);
    }

    @Override
    public List<BsUser> getActiveUser() {
        //活跃
        BsUserExample bsUserExample = new BsUserExample();
        bsUserExample.createCriteria().andBookCountGreaterThanOrEqualTo(50);
        return userMapper.selectByExample(bsUserExample);
    }

    @Override
    public List<BsPhone> getMessageList() {
        return userMapper.getMessageList();
    }

    @Override
    public void insertScore(Integer uid) {
        BsScore bsScore = new BsScore();
        bsScore.setUid(uid);
        bsScore.setScore(100);
        scoreMapper.insertSelective(bsScore);
    }

    @Override
    public List<BsScore> selectUserScoreByUid(Integer uid) {

        BsScoreExample bsScoreExample = new BsScoreExample();
        bsScoreExample.createCriteria().andUidEqualTo(uid);
        return scoreMapper.selectByExample(bsScoreExample);
    }
}
