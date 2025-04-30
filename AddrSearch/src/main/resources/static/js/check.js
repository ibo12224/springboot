function goPopup(){
	var pop = window.open("popup","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}

function jusoCallBack(roadAddrPart1,addrDetail, zipNo){
	document.member.roadAddrPart1.value = roadAddrPart1;
	document.member.addrDetail.value = addrDetail;
	document.member.zipNo.value = zipNo;
}
function check(){
	let form=document.member;
	
	if(form.id.value==""){
		alert("아이디를 입력하세요");
		return false;
	}
}