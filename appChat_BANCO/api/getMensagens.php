<?php
require "../config.php";

$method = strtolower( $_SERVER['REQUEST_METHOD']);
if($method === 'post'){

       $idUsuario = filter_input(INPUT_POST,'idUsuario');


       if($idUsuario){

      $sql = $pdo->prepare ("SELECT m.id,m.idUsuario,m.texto,m.data_create FROM mensagens as m inner join conversas as c on (m.idConversa = c.id) where c.idUsuario = :idUsuario");
        $sql->bindValue(':idUsuario',$idUsuario);
        $sql->execute();

        if($sql->rowCount() > 0){

            $data = $sql->fetchAll(PDO::FETCH_ASSOC);
            foreach ($data as $item){
                $data_create = new DateTime($item['data_create']);
            $array['mensagens'][] = [
                'id'=> $item['id'],
                'idUsuario' => $item['idUsuario'],
                'texto' => $item['texto'],
                'data_create' => $data_create->format('d/m/y H:i')
            ];
        }

        }else{

            $array['error'] = 'Sem dados';

        }

       }else{
           $array['error'] = "Não foi possível concluir operação";
       }

    

}else{
    $array['error'] = 'Metodo não permitido (Apenas POST)';
}

require "../return.php";