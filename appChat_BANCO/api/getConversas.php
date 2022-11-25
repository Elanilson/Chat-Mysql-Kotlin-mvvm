<?php
require "../config.php";

$method = strtolower( $_SERVER['REQUEST_METHOD']);
if($method === 'get'){

       $sql = $pdo->prepare ("SELECT c.id,c.idUsuario,u.nome,u.imagem as imagemUsuario, ( SELECT m.data_create FROM mensagens as m where m.idConversa = c.id ORDER BY m.data_create DESC limit 1) as data_create FROM conversas as c inner join usuarios as u on (c.idUsuario = u.id) where c.data_create IS NOT NULL ORDER BY data_create DESC");
        $sql->execute();

        if($sql->rowCount() > 0){

            $data = $sql->fetchAll(PDO::FETCH_ASSOC);
            foreach ($data as $item){
               
            $array['conversas'][] = [
                'id'=> $item['id'],
                'idUsuario' => $item['idUsuario'],
                'nome' => $item['nome'],
                'imagemUsuario' => $item['imagemUsuario'],
                'data_create' => $item['data_create']
            ];
        }

        }else{

            $array['error'] = 'Sem dados';

        }

}else{
    $array['error'] = 'Metodo não permitido (Apenas GET)';
}

require "../return.php";