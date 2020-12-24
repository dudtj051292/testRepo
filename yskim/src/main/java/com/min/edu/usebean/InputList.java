package com.min.edu.usebean;

import java.util.List;

import com.min.edu.dto.AnswerboardDto;

public class InputList {
	
	private List<AnswerboardDto> lists;
	
	public void setLists(List<AnswerboardDto> lists) {
		this.lists = lists;
	}
	public String getListForm() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < lists.size(); i++) {
			sb.append(listForm(lists.get(i)));
		}
		return sb.toString();
	}
	
	
	private String titleFormat(String d) {
		int depth = Integer.parseInt(d);
		StringBuffer sb = new StringBuffer();
		for(int i =0; i<depth; i++) {
			sb.append("&nbsp;&nbsp;&nbsp;&nbsp;");
		}
		if(depth!=0) {
			sb.append("<img src ='./images/reply.png'/>");
		}
		return sb.toString();
	}
	public String listForm(AnswerboardDto dto) {
		StringBuffer sb = new StringBuffer();

	
		sb.append("<tr>" );
		sb.append("<td><input type='checkbox' name ='chkval' value ='"+dto.getSeq()+"'></td>");
		sb.append("<td>"+dto.getSeq()+"</td>" );
		sb.append("<td>" );
		sb.append("<div class ='panel-heading'>" );
		sb.append("<a href =./detailBoard.do?seq="+dto.getSeq()+" >");
		
		sb.append(titleFormat(dto.getDepth()) + dto.getTitle());
		sb.append("</a>" );
		sb.append("</div>" );
		sb.append("</td>" );
		sb.append("<td>" );
		sb.append(dto.getId());
		sb.append("</td>" );
		sb.append("<td>" );
		sb.append(dto.getReadcount());
		sb.append("</td>" );
		sb.append("<td>"+dto.getDelflag()+"</td>");
		
		sb.append("<td>"+dateFormat(dto.getRegdate())+"</td>" );
		sb.append("</tr>" );
//		sb.append("<tr>" );
//		sb.append("<td colspan ="+n+">" );
//		sb.append("<div id ='collapse"+dto.getSeq()+"' class = 'panel-collapse collapse'>" );
//		sb.append("<div class ='form-group'>" );
//		sb.append("<label>"+"내용"+"</label><br>" );
//		sb.append("<textarea rows='7' class='form-controller' readonly='readonly'>"+dto.getContent()+"</textarea>" );
//		sb.append("</div>" );
//		sb.append("<div class = 'form-group'>" );
//		sb.append("<input type ='button' class = 'btn btn-primary' value ='글수정' onclick='modify(\""+dto.getSeq()+"\")'>");
//		sb.append("<input type ='button' class = 'btn btn-primary' value ='글삭제' onclick='del(\""+dto.getSeq()+"\")'>");
//		
//		sb.append("<input type ='button' class = 'btn btn-primary' value ='답글' onclick='reply(\""+dto.getSeq()+"\")'>");
//			
//		sb.append("</div>");
//		sb.append("</div>");
//		sb.append("</td>");
//		sb.append("</tr>");

	return sb.toString();


	}
	private String dateFormat(String date) {
		
		return date.substring(0,date.indexOf(" "));
	}
	
}
