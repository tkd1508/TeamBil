package com.reply.vo;

import lombok.Data;
import java.util.Date;

@Data
public class ReplyVO {
private int rno;
private int bno;

private String reply;
private String replyer;
private String replyDate;
private String updateDate;

}
