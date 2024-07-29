<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section>
	<div>%d page </div>
	<h1>성적 출력</h1>
	<table>
		<thead>
			<tr>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>총점</th>
				<th>평균</th>
				<th>성적</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="exam" items="${list}">
				<tr>
					<th><a href = "detail">${exam.name}</a></th>
					<td>${exam.kor}</td>
					<td>${exam.eng}</td>
					<td>${exam.math}</td>
					<td>${exam.total}</td>
					<td><fmt:formatNumber value="${exam.average}" pattern="0.00" /></td>
					<td>${exam.grade}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</section>	
<nav>
	<ul>
		<li><a href="?p=1&c=홍 길동&c=blue">1</a></li>
		<li><a href="?p=2&c=blue&c=red">2</a></li>
		<li><a href="?p=3&c=green">3</a></li>
		<li><a href="?p=4&c=red">4</a></li>
		<li><a href="?p=5&c=red">5</a></li>
	</ul>	
</nav>

<!-- 데이터 post전송 -->
<section>
	<form method="post">
		<fieldset>
			<legend>페이지 입력</legend>
			<label>page<input name="p" type="text"></label>
		</fieldset>
		<fieldset>
			<legend>좋아하는 색상</legend>
			<label><input name="c" value="red" type="checkbox">빨강</label>
			<label><input name="c" value="blue" type="checkbox">파랑</label>
		</fieldset>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
</section>


<!-- 파일 선택 업로드 -->
<section>
	<form method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>파일 업로드</legend>
			<!-- multiple="multiple" 파일 동시 선택 속성 -->
			<label>파일선택<input style="display:none;" name="img" multiple="multiple" type="file"></label>
			<button type="submit">업로드</button>
		</fieldset>
	</form>
</section>

<section>
	<div>
		<img src="/javaprj/notice/upload/14.jpg">
	</div>
		<div>
		<a download href="/javaprj/notice/upload/14.jpg">다운로드</a>
	</div>
</section>

</body>
</html>