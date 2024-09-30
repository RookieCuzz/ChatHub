package com.zhanganzhi.chathub.platforms.web.models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Builder
@Data
public class ChatMessageDTO {

    // 唯一ID，用于标识消息
    private Long id;

    // 聊天内容
    private String message;

    // 玩家唯一标识符，使用UUID
    private String playerUUID;

    // 服务器名称标识（可能是服务器ID）
    private String serverName;

    // 消息的时间戳
    private Date messageTimeStamp;

    //玩家姓名
    private String playerName;
}
