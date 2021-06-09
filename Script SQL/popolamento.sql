USE ecommerce;

 INSERT INTO Cliente(email,psw,nome,cognome,città,provincia,via,numeroCivico,cap) values
 ('gabrieletuozzo@gmail.com','123456','Gabriele','Tuozzo','San Gregorio Magno','SA','Via IV Novembre','26','84020'),
 ('lucarossi@gmail.com','abcdefgh','Luca','Rossi','Buccino','SA','Via Roma','51','84021'),
 ('andreaverdi@tiscali.it','qwertyuiop','Andrea','Verdi','Salerno','SA','Via Torrione','160','84121'),
 ('carlobianchi@gmail.com','ciao1','Carlo','Bianchi','Salerno','SA','Via Roma','40','84121'),
 ('leocarlo@gmail.com','abcdefg','Carlo','Leo','Fisciano','SA','Via Della Libertà','25','84084'),
 ('dellacortegiacomo@tiscali.it','ab1cd2','Giacomo','Della Corte','Montecorvino','SA','Via Piemonte','23','84096'),
 ('martinodauria@gmail.com','654321','Martino','DAuria','Montercorvino','SA','Via Piemonte','13','84096'),
 ('federicoferrari@outlook.com','fed1234','Federico','Ferrari','Roma','RM','Via Giovanni Ansaldo','32','00154'),
 ('danielet72@gmail.com','t72123','Daniele','Russo','Torino','TO','Via Nizza','154','10124'),
 ('francescarizzo@outlook.com','fra89','Francesca','Rizzo','Milano','MI','Corso Como','24','20154');


INSERT INTO Prodotto(codice,nome,genere,prezzo) values
('MZ-V7S250BW','SSD Samsung 860evo 500gb','componentistica PC','76.90'),
('CT8G4DFS824A','RAM Crucial 8gb DDR4 2400mt/s','componentistica PC','33.99'),
('MZ-76E500B/EU','SSD Samsung 970evo 250gb','componentistica PC','76.90'),
('BX80684I99700','Processore Intel Core i7-9700K 3,6 GHz','componentistica PC','399.99'),
('BX80684I79700','Processore Intel Core i5-9600K 3,7 GHz','componentistica PC','249.99'),
('BX80684I39100F','Processore Intel Core i3-8100 3,6 GHz','componentistica PC','129.90'),
('B99X304','Scheda video Asus ROG STRIX RTX 2060 Advanced Edition 6 GB GDDR6','componentistica PC','465.00'),
('4041K11','HardDisk SATA3 Toshiba 500gb','componentistica PC','29.99'),
('WDS250G3X0C','Western Digital SN750 NVMe Black-Unità SSD Interno 250 GB','componentistica PC','74.99'),
('CP-9020171-EU','Alimentatore Corsair VS550 Alimentatore da 550 W','componentistica PC','49.99'),
('CT102464BF160B','RAM per PC portatile Crucial 4gb 2400mt/s','componentistica pc','25.99'),
('A64789CBUHO9','iPhone 11 64gb nero','smartphone','749.00');

INSERT INTO Ordine(numeroOrdine,dataOrdine,importoOrdine,email,statoDiElaborazione)values 
('10245367452139',current_timestamp(),'25.99','andreaverdi@tiscali.it','SPEDITO'), 
('12321456984521','2019-11-06 08:45:49','74.99','gabrieletuozzo@gmail.com','IN LAVORAZIONE'), 
('45213987545318','2019-10-15 20:20:15','29.99','gabrieletuozzo@gmail.com','SPEDITO'),
('45236987452125','2019-10-18 20:20:15','749.00','lucarossi@gmail.com','PRONTO PER LA SPEDIZIONE'),
('78542216984565','2020-01-07 09:00:02','749.00','francescarizzo@outlook.com','IN LAVORAZIONE'),
('78522336541120','2020-01-10 15:34:12','33.99','leocarlo@gmail.com','IN LAVORAZIONE'),
('78954256321200','2020-01-02 07:45:00','465.00','federicoferrari@outlook.com','SPEDITO'),
('45125262320059','2019-12-25 12:15:59','399.99','dellacortegiacomo@tiscali.it','SPEDITO'),
('45152152752158','2019-11-02 23:25:10','49.99','danielet72@gmail.com','SPEDITO'),
('78523122224563','2020-01-13 14:20:03','29.99','martinodauria@gmail.com','PRONTO PER LA SPEDIZIONE'),
('78452554556214','2020-01-14 20:12:01','465.00','carlobianchi@gmail.com','IN LAVORAZIONE');

INSERT INTO Pagamento(IDPagamento,valuta,importo,dataPagamento,numeroOrdine) values
('00001','Euro','25.99',current_timestamp(),'10245367452139'),
('00002','Euro','74.99','2019-11-06 09:30:49','12321456984521'),
('00010','Euro','29.99','2019-10-18 22:10:12','45213987545318'),
('10001','Euro','749.00','2019-10-22 21:20:15','45236987452125'),
('10002','Euro','49.99','2019-11-02 23:54:02','45152152752158'),
('10003','Euro','399.99','2019-12-31 13:00:54','45125262320059'),
('00018','Euro','33.99','2020-01-10 15:40:00','78522336541120'),
('00019','Euro','29.99','2020-01-13 15:05:12','78523122224563'),
('00020','Euro','749.00','2020-01-07 09:11:12','78542216984565'),
('00012','Euro','465.00','2020-01-02 14:32:54','78954256321200');


INSERT INTO Contrassegno(città,provincia,CAP,via,numeroCivico,IDpagamento) values
('San Gregorio Magno','SA','84020','Via IV Novembre','26','00010'),
('Montecorvino','SA','84096','Via Piemonte','23','10003');


INSERT INTO CartaDiCredito(numeroCarta,intestatarioCarta,dataScadenza,IDpagamento) values
('5508041808120395','Andrea Verdi','01/21','00001'),
('4937329035395816','Francesca Rizzo','03/21','00020'),
('5128006056139366','Federico Ferrari','08/25','00012'),
('5485206232645180','Martino DAuria','12/12','00019');


INSERT INTO PayPal(email,psw,IDpagamento) values
('gabrieletuozzo@gmail.com','abcdefg1','00002'),
('lucarossi@gmail.com','123456789q','10001'),
('leocarlo@gmail.com','qwertypoiu','00018');


INSERT INTO AziendaCostruttrice(IDazienda) values
 ('10'),
 ('20'),
 ('5'),
 ('15'),
 ('25'),
 ('30'),
 ('55'),
 ('50'),
 ('12'),
 ('01');

INSERT INTO Gestore(codiceFiscale,ragioneSociale,IDazienda) values
('GGNRSS87A15F205W',NULL,'01'),
(NULL,'Samsung','20'),
(NULL,'Asus','25'),
(NULL,'Apple','55'),
(NULL,'Intel','10'),
(NULL,'WD','50'),
(NULL,'Corsair','30'),
(NULL,'Crucial','5'),
(NULL,'Toshiba','15');

INSERT INTO Magazzino (idMagazzino) values
('1'),
('2'),
('3');

INSERT INTO composto(quantità,codice,numeroOrdine) values
('1','CT102464BF160B','10245367452139'),
('1','A64789CBUHO9','10245367452139'),
('1','WDS250G3X0C','12321456984521'),
('1','4041K11','45213987545318'),
('1','A64789CBUHO9','45236987452125'),
('1','A64789CBUHO9','78542216984565'),
('1','CT8G4DFS824A','78522336541120'),
('1','B99X304','78954256321200'),
('1','BX80684I99700','45125262320059'),
('1','CP-9020171-EU','45152152752158'),
('1','4041K11','78523122224563');
 
INSERT INTO risiede(disponibilità,codice,IDmagazzino) values
('10','BX80684I79700',1),
('50','4041K11','1'),
('10','A64789CBUHO9','1'),
('5','MZ-V7S250BW','2'),
('7','CT8G4DFS824A','1'),
('1','MZ-76E500B/EU','3'),
('4','BX80684I99700','2'),
('8','BX80684I39100F',1),
('2','B99X304','2'),
('6','WDS250G3X0C',2),
('20','CP-9020171-EU',3),
('16','CT102464BF160B',1);

INSERT INTO costruito(codice,IDazienda) values
('BX80684I99700','10'),
('BX80684I39100F','10'),
('BX80684I79700','10'),
('MZ-V7S250BW','20'),
('MZ-76E500B/EU','20'),
('B99X304','25'),
('CT8G4DFS824A','5'),
('4041K11','15'),
('WDS250G3X0C','50'),
('CP-9020171-EU','30'),
('CT102464BF160B','5'),
('A64789CBUHO9','55');













