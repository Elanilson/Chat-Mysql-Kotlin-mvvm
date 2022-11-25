<?php
require "../config.php";

$method = strtolower( $_SERVER['REQUEST_METHOD']);
if($method === 'get'){


    $sql =  $pdo->query("select * from usuarios ");
    if($sql->rowCount() > 0){
        $data = $sql->fetchAll(PDO::FETCH_ASSOC);

        foreach ($data as $item){
         $array['contatos'] [] = [
                'id' => $item['id'],
                'nome' => $item['nome'],
                'imagem' => $item['imagem'],
                'idConversa' => $item['idConversa']
            ];

        }

    }
}else{
    $array['error'] = 'Metodo não permitido (Apenas GET)';
}

require "../return.php";