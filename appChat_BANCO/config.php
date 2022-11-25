<?php
$db_host = 'localhost';
$db_name = 'NOME_DO_SEU_BANCO';
$db_user = 'USUARIO';
$db_pass = 'SENHA';

$pdo = new PDO("mysql:dbname=$db_name;host=$db_host",$db_user,$db_pass);

$array =  [
 'error' => ''
 ];