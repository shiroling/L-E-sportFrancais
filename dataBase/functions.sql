CREATE OR REPLACE FUNCTION IS_ARBITRE (nom in varchar, mdp in varchar, idRencontre in number) RETURN boolean 
    IS
        idArbitreLogin number;
        idArbitreRencontre number;
    BEGIN
        SELECT id_arbitre into idArbitreLogin FROM arbitre a WHERE a.nom = nom AND a.mdp = mdp;
        SELECT id_arbitre into idArbitreRencontre FROM rencontre r WHERE r. id_rencontre = idRencontre;
        return idArbitreLogin = idArbitreRencontre;
    END IS_ARBITRE;
    
    
CREATE OR REPLACE FUNCTION IS_MANAGER (nom in varchar, mdp in varchar, idEquipe in number) RETURN boolean 
    IS
        idEcurieLogin number;
        idEcurieEquipe number;
    BEGIN
        SELECT id_Ecurie into idEcurieLogin FROM ecurie ec WHERE ec.nom_manager = nom AND ec.mdp_manager = mdp;
        SELECT id_Ecurie into idEcurieEquipe FROM equipe eq WHERE eq.id_equipe = idEquipe;
        return idEcurieLogin = idEcurieEquipe;
    END IS_MANAGER;


    