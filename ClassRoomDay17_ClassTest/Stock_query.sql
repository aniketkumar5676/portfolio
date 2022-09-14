use groww_brokerage;

-- showing user info if user id and password are valid
select user_name,user_id,membership_date,stock_holding_id from user_members where user_id = 4565464 && passwords ='sdk567nsr';

-- showing selected user stock holding
select * from stock_holding where user_id = 4565464;

-- showing selected user stock order 
select * from orders where user_id = 4565464;

-- showing watch list of selected user
select * from watchlist;





-- selected user wants to book/buy stocks

-- showing current stock values
select * from stock;

-- buying one of the stock available in list from any exchange BSE or NSE
insert into stock_exchange values (1,'NSE',1238);

-- updating its holding
insert into stock_holding values (20,4565464,'Adani','ADANI',340);

-- updating its orders on booked

insert into orders values ((select order_no from stock_exchange where s_no=1),(select share_name from stock_holding where stock_id=20),'132','Booked',0,'2022-09-12','12',(select user_id from stock_holding where stock_id =20));

-- showing selected user stock holding
select * from stock_holding where user_id = 4565464;

