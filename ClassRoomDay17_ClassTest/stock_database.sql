drop database if exists `Groww_Brokerage`;
create database `Groww_Brokerage`;
use `Groww_Brokerage`;

create table orders(
order_no int NOT NULL AUTO_INCREMENT,
stock varchar (50) NOT NULL,
price varchar (50) NOT NULL,
status varchar (50) NOT NULL,
is_buy_order int NOT NULL ,
booking_time varchar (50) NOT NULL ,
quantity varchar (50) NOT NULL,
user_id int NOT NULL,
primary key (order_no)
)AUTO_INCREMENT=1 ;

INSERT INTO orders VALUES      (1232,'Tata_Steel','128','Not_Booked',1,'2022-09-12','12',4565464),
                               (1233,'Adani_Ports','2128','Not_Booked',1,'2022-09-12','3',4565464),
                               (1234,'Reliance','2228','Not_Booked',1,'2022-09-12','5',4565465),
                               (1235,'NMDC','128','Not_Booked',1,'2022-09-12','120',4565466),
                               (1236,'ITC','328','Not_Booked',1,'2022-09-12','120',4565467),
                               (1237,'INFY','28','Not_Booked',1,'2022-09-12','120',4565468);

                               
                 
                 
create table stock_exchange(
s_no int NOT NULL AUTO_INCREMENT,
exchange_name_BSE_NSE varchar (50) NOT NULL ,
order_no int NOT NULL,

KEY s_id (s_no)
)AUTO_INCREMENT=1 ;



create table user_members(
user_id int NOT NULL AUTO_INCREMENT,
user_name varchar (50) NOT NULL,
passwords varchar (50) NOT NULL,
membership_date varchar (50) NOT NULL,
stock_holding_id int NOT NULL , 

primary key (user_id)

)AUTO_INCREMENT=1 ;
                    
INSERT INTO user_members VALUES(4565464,'parth2223','sdk567nsr','2022-09-27',15),
                               (4565465,'dev.k','fr545r43','2022-05-09',16),
                               (4565466,'Abhay','82824822','2022-02-23',17),
                               (4565467,'Inaya','885hftd','2022-01-17',18),
                               (4565468,'Kanan','jjy6567','2022-05-12',19);
                             
                     
 create table stock_holding(
stock_id int NOT NULL AUTO_INCREMENT,
user_id int NOT NULL ,
share_name varchar (50) NOT NULL,
share_name_code varchar (50) NOT NULL,
quantity varchar (50) NOT NULL,

primary key (stock_id)

)AUTO_INCREMENT=1 ;
                    
INSERT INTO stock_holding VALUES(15,4565464,'Tata_Steel','TATASTEEL',111),
                               (16,4565465,'Wipro','WIPRO',239),
                               (17,4565466,'Airtel','BHARTIARTL',32),
                               (18,4565467,'Itc','ITC',190),
                               (19,4565468,'Wipro','WIPRO',39);
                              

create table watchlist(
stock_name varchar (250) NOT NULL ,
stock_code varchar (250) NOT NULL 
);
INSERT INTO watchlist VALUES('Tata_Steel','TATASTEEL'),   
         ('Airtel','BHARTIARTL'), 
         ('ACC','ACC'), 
         ('GAIL ','GAIL '), 
         ('Reliance Industries Ltd','RELIANCE'), 
         ('Titan Company Ltd','TITAN'), 
         ('Infosys Ltd','INFY');
         
         
  
create table stock(
stock_id int NOT NULL ,
stock_name varchar (250) NOT NULL ,
current_price int NOT NULL
);                                         
INSERT INTO stock VALUES(1,'TATASTEEL',123),   
         (2,'BHARTIARTL',765), 
         (3,'ACC',2334), 
         (4,'GAIL',332), 
         (5,'RELIANCE',2345), 
         (6,'TITAN',3324), 
         (7,'INFY',1500);
                                      
                               