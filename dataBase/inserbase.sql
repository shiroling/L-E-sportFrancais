Insert INTO ECURIE values(seq_ECURIE.nextval, 'Vitality', 'Chevalier', '$iutinfo');
Insert INTO ECURIE values(seq_ECURIE.nextval, 'KCorp', 'Kameto', '$iutinfo');
Insert INTO ECURIE values(seq_ECURIE.nextval, 'Cloud9', 'JspKi', '$iutinfo');
Insert INTO ECURIE values(seq_ECURIE.nextval, 'Mandatory', 'ZeratoR', '$iutinfo');
Insert INTO ECURIE values(seq_ECURIE.nextval, 'SaltyPlayers', 'Sardoche', '$iutinfo');
Insert INTO ECURIE values(seq_ECURIE.nextval, 'Solary', 'Charles', '$iutinfo');

Insert INTO jeu values(seq_JEU.nextval, 'Overwatch 2');
Insert INTO jeu values(seq_JEU.nextval, 'Valorant');
Insert INTO jeu values(seq_JEU.nextval, 'Rocket League');
Insert INTO jeu values(seq_JEU.nextval, 'League of Legends');

Insert INTO EQUIPE values(seq_equipe.nextval, 'Philadelphia_Fusion', 1, 5);
Insert INTO EQUIPE values(seq_equipe.nextval, 'Mandatory Valorant', 2, 4);
Insert INTO EQUIPE values(seq_equipe.nextval, 'BSD', 3, 6);
Insert INTO EQUIPE values(seq_equipe.nextval, 'Kcorp LOL', 4, 2);

Insert INTO JOUEUR values(seq_JOUEUR.nextval, 'GOUZERCH', 'Gael', to_date('21/07/1996','DD/MM/YYYY'), 'Poko', 1);
Insert INTO JOUEUR values(seq_JOUEUR.nextval, 'DIEULAFAIT', 'Benjamin', to_date('17/11/1995','DD/MM/YYYY'), 'BenBest', 1);
Insert INTO JOUEUR values(seq_JOUEUR.nextval, 'TARLIER', 'Terence', to_date('04/02/1994','DD/MM/YYYY'), 'SoOn', 1);
Insert INTO JOUEUR values(seq_JOUEUR.nextval, 'MONSCAVOIR', 'Brice', to_date('27/08/2001','DD/MM/YYYY'), 'FDGod', 1);
Insert INTO JOUEUR values(seq_JOUEUR.nextval, 'CHOUCHAYAN', 'Patrick', to_date('23/09/1969','DD/MM/YYYY'), 'FiorI', 1);

Insert INTO GERANT values(seq_gerant.nextval, 'Bardeau', '$iutinfo');
Insert INTO GERANT values(seq_gerant.nextval, 'Bard', '$iutinfo');
Insert INTO GERANT values(seq_gerant.nextval, 'Estlà', '$iutinfo');
Insert INTO GERANT values(seq_gerant.nextval, 'Caffeine', '$iutinfo');

Insert INTO TOURNOI values(SEQ_TOURNOI.nextval, 'RL pro lan series', 'International', to_date('21/10/2022','DD/MM/YYYY'), to_date('24/10/2022','DD/MM/YYYY'), to_date('25/10/2022','DD/MM/YYYY'), 1);
Insert INTO TOURNOI values(SEQ_TOURNOI.nextval, 'OW contenders', 'International', to_date('21/12/2022','DD/MM/YYYY'), to_date('24/01/2022','DD/MM/YYYY'), to_date('25/02/2022','DD/MM/YYYY'), 2);
Insert INTO TOURNOI values(SEQ_TOURNOI.nextval, 'Worlds LOL', 'International', to_date('21/04/2022','DD/MM/YYYY'), to_date('24/05/2022','DD/MM/YYYY'), to_date('25/05/2022','DD/MM/YYYY'), 3);
Insert INTO TOURNOI values(SEQ_TOURNOI.nextval, 'LFL', 'National', to_date('21/06/2022','DD/MM/YYYY'), to_date('24/06/2022','DD/MM/YYYY'), to_date('25/06/2022','DD/MM/YYYY'), 3);

Insert INTO ARBITRE values(SEQ_ARBITRE.nextval, 'Charles', '$iutinfo');
Insert INTO ARBITRE values(SEQ_ARBITRE.nextval, 'Collina', '$iutinfo');
Insert INTO ARBITRE values(SEQ_ARBITRE.nextval, 'Pierreluigi', '$iutinfo');