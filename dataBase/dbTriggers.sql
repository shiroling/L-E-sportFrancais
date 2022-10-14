create or replace TRIGGER T_B_IU_INSCRIT_CARD 
BEFORE INSERT OR UPDATE OF ID_TOURNOI ON INSCRIT for each row
DECLARE
vCOMPTEUR INTEGER;
BEGIN
  select count(*) into vCOMPTEUR
    from INSCRIT i
    where i.id_tournoi =: new.id_tournoi
    GROUP BY i.id_tournoi;
    
    if vCOMPTEUR = 16 then 
        raise_application_error(-25565, 'Il y a déjà 16 équipes inscrites à ce tournoi');
    end if;
    
    exception
    WHEN No_data_found then   
        return;
END;

CREATE OR REPLACE TRIGGER T_B_IU_COMPOSER_CARD 
BEFORE INSERT OR UPDATE OF ID_POULE ON COMPOSER for each row
DECLARE
vCOMPTEUR INTEGER;
BEGIN
  select count(*) into vCOMPTEUR
    from COMPOSER x
    where x.id_poule =: new.id_poule
    GROUP BY x.id_poule;
    
    if vCOMPTEUR = 4 then 
        raise_application_error(-25565, 'Il y a déjà 4 équipes dans cette poule');
    end if;
    
    exception
    WHEN No_data_found then   
        return;
END;

CREATE OR REPLACE TRIGGER T_B_IU_RENCONTRE_CARD 
BEFORE INSERT OR UPDATE OF ID_POULE ON RENCONTRE for each row
DECLARE
vCOMPTEUR INTEGER;
BEGIN
  select count(*) into vCOMPTEUR
    from RENCONTRE x
    where x.id_poule =: new.id_poule
    GROUP BY x.id_poule;
    
    if vCOMPTEUR = 6 then 
        raise_application_error(-25565, 'Il y a déjà 6 rencontre liées à cette poule');
    end if;
    
    exception
    WHEN No_data_found then   
        return;
END;

CREATE OR REPLACE TRIGGER T_B_IU_POULE_CARD 
BEFORE INSERT OR UPDATE OF ID_TOURNOI ON POULE for each row
DECLARE
vCOMPTEUR INTEGER;
BEGIN
  select count(*) into vCOMPTEUR
    from POULE x
    where x.id_tournoi =: new.id_tournoi
    GROUP BY x.id_tournoi;
    
    if vCOMPTEUR = 5 then 
        raise_application_error(-25564, 'Il y a déjà 5 poules formées pour ce tournoi');
    end if;
    
    exception
    WHEN No_data_found then   
        return;
END;

create or replace TRIGGER T_B_IU_JOUER_CARD 
BEFORE INSERT OR UPDATE OF ID_RENCONTRE ON JOUER for each row
DECLARE
vCOMPTEUR INTEGER;
BEGIN
  select count(*) into vCOMPTEUR
    from JOUER x
    where x.id_rencontre =: new.id_rencontre
    GROUP BY x.id_rencontre;
    
    if vCOMPTEUR = 2 then 
        raise_application_error(-25562, 'Il y a déjà 2 équipes Jouant dans cette rencontre');
    end if;
    
    exception
    WHEN No_data_found then   
        return;
END;

CREATE OR REPLACE TRIGGER T_B_IU_JOUEUR 
BEFORE INSERT OR UPDATE OF ID_EQUIPE ON JOUEUR for each row
DECLARE
vCOMPTEUR INTEGER;

BEGIN
  select count(*) into vCOMPTEUR
    from JOUEUR x
    where x.id_equipe =: new.id_equipe
    GROUP BY x.id_equipe;
    
    if vCOMPTEUR = 4 then 
        raise_application_error(-25565, 'Il y a déjà 4 Joueurs dans cette équipe');
    end if;
    
    exception
    WHEN No_data_found then   
        return;
END;