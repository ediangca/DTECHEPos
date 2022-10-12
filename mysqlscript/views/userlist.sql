DROP VIEW IF EXISTS `userlist`;
CREATE OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `userlist` AS
select `u`.`User_ID` AS `USER_ID`,
concat(`p`.`Lastname`,_latin1', ',`p`.`Firstname`,_latin1' ',substr(`p`.`Middlename`,1,1)) AS `Fullname`,
`d`.`Department` AS `Department`,`ps`.`Position` AS `Position`,`u`.`isActive` AS `isActive`,
`p`.`Datetime_Created` AS `Datetime_Created`,`p`.`Datetime_Updated` AS `Datetime_Updated`
from (((`user` `u` join `user_profile` `p` on((`u`.`User_ID` = `p`.`User_ID`)))
join `user_department` `d` on((`p`.`Department_No.` = `d`.`Department_No.`)))
join `user_position` `ps` on((`p`.`Position_No.` = `ps`.`Position_No.`)))
where (`u`.`cancelflag` = 0) order by `u`.`User_ID`;