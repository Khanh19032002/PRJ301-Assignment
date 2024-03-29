-- Time Table
select s.sessionID , s.sessionDate , sg.stuGroup,
                    g.gName , l.lectureName ,l.[login] , l.email, su.subID , su.subName , s.RoomID , s.SlotNO 
                    from [Session] s join Room r on s.RoomID = r.Room_ID
                    inner join Student_Group sg on sg.stuGroup = s.stuGroup
                    inner join Slot sl on sl.slotNO = s.SlotNO
                    inner join Lecturer l on sg.lecture_Login = l.[login]
                    inner join [Group] g on sg.gname = g.gname
                    inner join [Subject] su on sg.subID = su.subID
                    where l.login = ?

select * from Slot

--Attendance SQL
select a.aid , s.[sID] , s.[login] , s.sName
, se.sessionID , se.stuGroup ,a.[status] from Attend a 
 inner join [Session] se on a.sessionID = se.sessionID
 inner join Student s on s.[sID] = a.[stuID]
 where se.sessionID = ?

select s.[login] , s.[sID] , s.[sName] from [Session] se
inner join Student_Group sg on se.stuGroup = sg.stuGroup 
inner join Enroll e on e.stuGroup = sg.stuGroup
inner join Student s on s.[sID] = e.[sID]
where se.sessionID = ?

select s.sessionID , s.sessionDate , sg.stuGroup,
                     g.gName , l.[password], l.lectureName ,l.[login] , l.email, su.subID , su.subName , s.RoomID , s.SlotNO 
                   from [Session] s join Room r on s.RoomID = r.Room_ID
                    inner join Student_Group sg on sg.stuGroup = s.stuGroup
                    inner join Slot sl on sl.slotNO = s.SlotNO
                    inner join Lecturer l on sg.lecture_Login = l.[login]
                    inner join [Group] g on sg.gname = g.gname
                    inner join [Subject] su on sg.subID = su.subID
                    where s.sessionID = ?

--Insert and Update Attendance
INSERT INTO [dbo].[Attend]
           ([status]
           ,[stuID]
           ,[sessionID])
     VALUES
           (?,?,?)

Update [Attend] set [status]= ? where aid = ?


--Report sql
 select * from Student_Group sg 
 inner join Lecturer l on l.[login] = sg.lecture_Login 
 inner join [Group] g on sg.gName = g.gName
 inner join [Subject] su on sg.subID = su.subID
 where l.[login] = ?

 select a.aid , a.[status] , a.stuID , st.[login], st.sName , a.sessionID from Attend a 
 left join Student st on a.stuID = st.[sID]
 inner join [Session] se on a.sessionID = se.sessionID
 where se.stuGroup = ?
 
 select s.[sessionID] from [Session] s inner join Student_Group sg on s.stuGroup = sg.stuGroup
 where sg.stuGroup = ?

 select * from [Student] s 
 inner join Enroll e on e.[sID] = s.[sID]
 inner join Student_Group sg on e.stuGroup = sg.stuGroup
 where sg.stuGroup = ?