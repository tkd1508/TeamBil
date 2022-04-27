package com.reply.vo;

import lombok.Data;
import java.util.Date;


// 댓글 DTO
@Data
public class ReplyVO {
private Long rno;
private Long bno;

private String reply;
private String replyer;
private Date replyDate;
private Date updateDate;

}
