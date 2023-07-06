package cn.chendahai.service;

import cn.chendahai.entity.ErrorLog;

public interface ErrorLogService {

    String sendMsg(ErrorLog errorLog);

    void asyncSendMsg(ErrorLog errorLog);
}
