<?php
require "../config.php";

$method = strtolower( $_SERVER['REQUEST_METHOD']);
if($method === 'post'){

    $id = filter_input(INPUT_POST,'idUsuario');

         $sql = $pdo->prepare ("SELECT * FROM usuarios WHERE id = :id");
        $sql->bindValue(':id',$id);
        $sql->execute();

    if($sql->rowCount() > 0){
        $data = $sql->fetchAll(PDO::FETCH_ASSOC);

        foreach ($data as $item){
         $array['usuario'] = [
                'id' => $item['id'],
                'nome' => $item['nome'],
                'imagem' => $item['imagem'],
                'idConversa' => $item['idConversa']
                    ];

        }

    }else{
        $array['error'] = 'Usuário não encontrado';
    }
}else{
    $array['error'] = 'Metodo não permitido (Apenas GET)';
}

require "../return.php";
