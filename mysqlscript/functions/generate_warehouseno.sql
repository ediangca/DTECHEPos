DELIMITER $$

DROP FUNCTION IF EXISTS `generate_warehouseno` $$
CREATE DEFINER=`root`@`localhost` FUNCTION `generate_warehouseno`() RETURNS varchar(45) CHARSET latin1
BEGIN

declare cnt int(10);
declare lastid int(10);
declare id varchar(45);

set cnt = (select count(*) from warehouse
where year(datetime_created) = year(curdate()));

set lastid = (select substr(`Warehouse_No.`,11) from warehouse
where year(datetime_created) = year(curdate()) order by (substr(`Warehouse_No.`,11)+1) desc limit 1);

if(cnt = 0)then

set id = (select concat('WRH', year(curdate()) , '001'));

else

set id = (select concat('WRH', year(curdate()), '00', (lastid+1)));

end if;


return id;

END $$

DELIMITER ;