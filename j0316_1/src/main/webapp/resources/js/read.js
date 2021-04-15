
const dqs = document.querySelector.bind(document);
//const obj = dqs(".listBtn")
const actionForm = document.querySelector(".actionForm");
//console.log(obj)


//console.log(dqs(".table").querySelector("textarea[name=content]").value)
const bno = dqs(".table-striped").querySelector("input[name='bno']").value
console.log(bno)

console.log(dqs(".table-striped").querySelector("input[name='bno']").value)
console.log(actionForm.querySelector("input[name='bno']"))


/* ------------------------------목록 이동 이벤트------------------------------ */


dqs(".listBtn").addEventListener("click",function(e){

actionForm.setAttribute("action","/board/list")
actionForm.submit();

},false)


/* ------------------------------수정/삭제 이동 이벤트------------------------------ */


dqs(".modBtn").addEventListener("click",function(e){
	//actionForm.innerHTML+="<input type='hidden' name='bno' value='${board.bno}'>"
	actionForm.setAttribute("action","/board/modify")
	actionForm.submit();
	
	
},false)




/* ------------------------------페이지 이동 이벤트------------------------------ */

document.querySelector(".pagination").addEventListener("click",e=>{
	e.preventDefault();
	const target = e.target;
	console.log(target);
	const pageNum = target.getAttribute("href");
	if(pageNum == null){
	return;
	}
	console.log(pageNum);
	
	document.querySelector(".actionForm input[name='page']").value=pageNum;
	actionForm.innerHTML += "<input type='hidden' name='bno' value='"+bno+"'>";
	actionForm.submit();
	
},false);

/* ------------------------------게시글 이동 이벤트------------------------------ */

document.querySelectorAll(".listA").forEach(a => {
	a.addEventListener("click",function(e) {
		e.preventDefault();
		const bno = e.target.getAttribute("href");
		;
		actionForm.setAttribute("action","/board/read");
		//console.log(bno)
		
		actionForm.innerHTML += "<input type='hidden' name='bno' value='"+bno+"'>";
		console.log(actionForm.querySelector("input[name=bno]"))
		actionForm.submit();
	},false);
})
/* ------------------------------검색(엔터) 이벤트------------------------------ */
document.querySelector(".searchInput").addEventListener('keypress',function(e){
	if(e.key === 'Enter'){
		//검색타입과 키워드를 가져와야한다
	
	const stype = document.querySelector(".stype");
	const idx = stype.selectedIndex;
	const type = stype[idx].value;
	
	//alert(type);
	//검색시 페이지 1로 초기화
	actionForm.querySelector("input[name='page']").value = 1;
	actionForm.querySelector("input[name='type']").value = type;
	actionForm.querySelector("input[name='keyword']").value = 
		document.querySelector("input[name='skeyword']").value;
	
	actionForm.submit();
	}
},false)


/* ------------------------------검색 이벤트------------------------------ */

document.querySelector(".searchBtn").addEventListener("click",function(e){
	
	//검색타입과 키워드를 가져와야한다
	//console.log(actionForm.querySelector(".stype").selectedIndex);
	const stype = document.querySelector(".stype");
	const idx = stype.selectedIndex;
	const type = stype[idx].value;
	
	//alert(type);
	//검색시 페이지 1로 초기화
	actionForm.querySelector("input[name='page']").value = 1;
	actionForm.querySelector("input[name='type']").value = type;
	actionForm.querySelector("input[name='keyword']").value = 
		document.querySelector("input[name='skeyword']").value;
	
	actionForm.submit();
},false)

/* ------------------------------글쓰기 이벤트------------------------------ */

dqs(".registerBtn").addEventListener("click",function(){
	
	self.location="/board/register";
	
},false)

/* ------------------------------------------------------------ */
/* ---------------------------댓글 처리-------------------------- */
/* ------------------------------------------------------------ */


    const replyService = (function () {
	
    
        function getList(data) {
        
        const page = actionForm.querySelector("input[name='page']").value;
        
            return fetch("http://192.168.0.101:8080/replys/read/" + bno + "/" + page,
                {
                    method: 'get'
                }
            ).then(res => res.json())
        }
        
        return {getList:getList}
    })();
    

    document.addEventListener('DOMContentLoaded', function () {

        const bnoValue = actionForm.querySelector("input[name='bno']").value;
        const pageValue = actionForm.querySelector("input[name='page']").value;
        
        console.log(bnoValue);
        console.log(pageValue);
        
        var replyUL = document.querySelector(".chat");
        
		//console.log(replyService.getList(bnoValue,pageValue).then(res=>res);
		
		console.log(replyService.getList({bno: bnoValue, page: pageValue || 1}));
		console.log(replyService.getList({bno: bnoValue, page: pageValue || 1}).then(list => console.log(list)));
		
        function showList(pageValue) {
            replyService.getList({bno: bnoValue, page: pageValue || 1}).then(list => {
                var str = "";
                if (list == null || list.length == 0) {
                    replyUL.html("");
                    return;
                }
                for (var i = 0, len = list.length || 0; i < len; i++) {
                    str += "<li class = 'left clearfix' data-rno='" + list[i].rno + "'>";
					str += "<div><div class='header'>";
					str += "<strong class='primary-font'>" + list[i].replyer + "</strong>";
					str += "<small class='pull-right text-muted'>" + list[i].replyDate + "</small>";
					str += "</div><p>"+list[i].reply+"</p></div></li>";
                }
                replyUL.innerHTML=str;
            });
        }
        
console.log(showList(pageValue));
    });










