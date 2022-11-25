<?php
require "../config.php";

$method = strtolower( $_SERVER['REQUEST_METHOD']);
if($method === 'put'){
    
    parse_str(file_get_contents('php://input'),$input);

    $idMensagem = $input['idMensagem'] ?? null;



    $idMensagem = filter_var($idMensagem);



    if($idMensagem ){

        $sql = $pdo->prepare('SELECT * FROM mensagens WHERE id = :idMensagem');
        $sql->bindValue(':idMensagem',$idMensagem);
        $sql->execute();

        if($sql->rowCount() > 0){

            $sql = $pdo->prepare('UPDATE mensagens  SET visualizado = :visualizado WHERE id = :idMensagem');
            $sql->bindValue(':idMensagem', $idMensagem);
            $sql->bindValue(':visualizado',"SIM");
            $sql->execute();

            $array['status'] = true;

        }else{
            $array['error'] = 'Operação não pode ser concluida';
        }
    }else{
        $array['error'] = 'Não foi possível concluir operação';
    }

}else{
    $array['error'] = 'Metodo não permitidMensagemo (Apenas PUT).';
}

require "../return.php";