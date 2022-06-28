-- Time Table
select se.sessionDate , se.RoomID , se.SlotNO , sg.lecture_Login from [Session] se join Student_Group sg on se.stuGroup = sg.stuGroup
--Attendance Taking
select s.img , s.[login], s.[sID] , s.sName from [Session] se 
join Student_Group sg on se.stuGroup = sg.stuGroup 
join Student s on s.gName = sg.gName
Insert into Attendance values (attendance , sID , status , sessionId)
--Attendance Report
select se.sessionDate , a.attendance , s.sID , s.sName  from [Session] se join Attendance a on se.sessionID = a.sessionID join Student s on s.sID = a.sID