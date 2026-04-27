<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	   <form name="MatchesRegistration" method="post" action="MatchRegistrationController">
	     <input type="text" name="sportname" id="sportname" placeholder="sportname">
	     <input type="text" name="team1" id="team1" placeholder="team1">
	     <input type="text" name="team2" id="team2" placeholder="team2">
	     <input type="text" name="matchdate" id="matchddate" placeholder="matchdate">
	     <input type="text" name="matchtime" id="matchtime" placeholder="matchtime">
	     <input type="text" name="venue" id="venue" placeholder="venue">
         <input type="text" name="status" id="status" placeholder="status">
	     <button type="submit">Submit</button>
	   </form>
	</body>
</html>