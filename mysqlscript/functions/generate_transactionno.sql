DELIMITER $$

DROP FUNCTION IF EXISTS `generate_transactionno` $$
CREATE DEFINER=`root`@`localhost` FUNCTION `generate_transactionno`(companyNo varchar(45), counterID varchar(45)) RETURNS varchar(45) CHARSET latin1
BEGIN

declare cnt int(10);
declare lastid varchar(45);
declare id varchar(45);

set cnt = (select count(*) from `transaction` where `company_no.` = companyNo
 and counter_id = counterID
and year(datetime_created) = year(curdate()));
-- substr(generate_transactionno('101','1001'), 17)

set lastid = (select (substr(`Transaction_No.`,17)) from `transaction`
where `company_no.` = companyNo and counter_id = counterID
and year(datetime_created) = year(curdate())
order by (substr(`Transaction_No.`,17)+1) desc limit 1);

if(cnt = 0)then

set id = (select concat('TRN', companyNo, counterID ,year(curdate()) , '001'));

else

set id = (select concat('WH', year(curdate()), '00', (lastid+1)));

end if;

return id;

END $$

DELIMITER ;