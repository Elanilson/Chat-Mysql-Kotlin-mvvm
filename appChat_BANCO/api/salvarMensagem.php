<?php
require "../config.php";

$method = strtolower( $_SERVER['REQUEST_METHOD']);
if($method === 'post'){

    $idUsuario = filter_input(INPUT_POST,'idUsuario');
    $texto = filter_input(INPUT_POST,'texto');
    $idConversa = filter_input(INPUT_POST,'idConversa');


    if( $idUsuario && $texto && $idConversa){


    $sql = $pdo->prepare('INSERT INTO mensagens (idUsuario,texto,idConversa) VALUES ( :idUsuario,:texto,:idConversa)');
    $sql->bindValue('idUsuario',$idUsuario);
    $sql->bindValue('texto',$texto);
    $sql->bindValue('idConversa',$idConversa);
    $sql->execute();

    $id = $pdo->lastInsertId();

    if($id){
        $array['status'] = true;
    }else{
        $array['status'] = false;
    }

  /*  if($id){
      //  sleep(4);
        $sql = $pdo->prepare ("SELECT * FROM mensagens WHERE id = :id");
        $sql->bindValue(':id',$id);
        $sql->execute();

        $data = $sql->fetch(PDO::FETCH_ASSOC);

       $data_create = new DateTime($data['data_create']);
        $array['mensagem'] = [
                'id'=> $data['id'],
                'idUsuario' => $data['idUsuario'],
                'texto' => $data['texto'],
                'visualizado' => $data['visualizado'],
                'data_create' => $data_create->format('H:i')
            ];
    }else{
        $array['status'] = false;
    }*/

    }else{
        $array['error'] = 'Chat não disponivél no momento';
    }


}else{
    $array['error'] = 'Metodo não permitido (Apenas POST)';
}

require "../return.php";