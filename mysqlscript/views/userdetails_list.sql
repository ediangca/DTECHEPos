DROP VIEW IF EXISTS `userdetails_list`;
CREATE OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `userdetails_list` AS
select `u`.`User_ID` AS `User_ID`,`u`.`Username` AS `Username`,`u`.`Password` AS `Password`,`u`.`isActive` AS `uia`,
`u`.`Datetime_Created` AS `udtc`,`u`.`Datetime_Updated` AS `udtu`,`u`.`cancelflag` AS `cancelflag`,
`c`.`Company_No.` AS `Company_No.`,`c`.`Company_Name` AS `Company_Name`,`c`.`Owner` AS `Owner`,`c`.`Contact_No.` AS `CContact_No`,
`c`.`Email_Address` AS `Email_Address`,`c`.`Address` AS `CAddress`,`c`.`Logo` AS `Logo`,`c`.`isActive` AS `cia`,
`c`.`Datetime_Created` AS `cdtc`,`c`.`Datetime_Updated` AS `cdtu`,`p`.`Profile_No.` AS `Profile_No.`,`p`.`Lastname` AS `Lastname`,
`p`.`Firstname` AS `Firstname`,`p`.`Middlename` AS `Middlename`,`p`.`Sex` AS `Sex`,
`p`.`Birthday` AS `Birthday`,`p`.`Address` AS `PAddress`,`p`.`Email` AS `Email`,`p`.`Contact_No.` AS `PContact_No`,
`p`.`Datetime_Created` AS `pdtc`,`p`.`Datetime_Updated` AS `pdtu`,`d`.`Department_No.` AS `Department_No.`,
`d`.`Department` AS `Department`,`d`.`isActive` AS `dia`,`d`.`Datetime_Created` AS `ddtc`,`d`.`Datetime_Updated` AS `ddtu`,
`ps`.`Position_No.` AS `Position_No.`,`ps`.`Position` AS `Position`,`ps`.`isActive` AS `pia`,`ps`.`Datetime_Created` AS `psdtc`,
`ps`.`Datetime_Updated` AS `psdtu` from
((((`user` `u`
join `company` `c` on((`u`.`Company_No.` = `c`.`Company_No.`)))
join `user_profile` `p` on((`u`.`User_ID` = `p`.`User_ID`)))
join `user_department` `d` on((`p`.`Department_No.` = `d`.`Department_No.`)))
join `user_position` `ps` on((`p`.`Position_No.` = `ps`.`Position_No.`))) where (`u`.`cancelflag` = 0);