#l/bin/bash
#18/04/2023

clear
echo "Menu"
echo "----"

salir="1"

while salir=="1"
do
echo "1. Control de version"
echo "2. Configurar usuario, email, password"
echo "3. Realizar primer commit"
echo "4. Realizar commit sobre el ultimo"
echo "5. Configurar repositorio remoto"
echo "6. Cambiar nombre de la rama principal de Master a main"
echo "7. Subir repositorio a remoto"
echo "8. Salir"

op=""
ruta="https://github.com/marcos24ps/Java_Ejecutable.git"
echo
read -p "Escriba su opcion (1-8)" op

case $op in
1)
	echo "1. Control de version"
	git init
	read -rsp $"\nPress any key to continue.."
;;
2)
	echo "2. Configurar usuario, email, password"
	git config user.name "marcos24ps"
	git config user.email "marcos24ps@gmail.com"
	git config user.password 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
	read -rsp $"\nPress any key to continue.."
;;
3)
	echo "3. Realizar primer commit"
	git add .
	git commit -m "25.04.2023.22.40"
	read -rsp $"\nPresss any key to continue.."
;;
4)
	echo "4. Realizar commit sobre el ultimo"
	git commit --ammend
	read -rsp $"\nPress any key to continue.."
;;
5)
	echo "5. Configurar repositorio remoto"
	git remote add origin $ruta
	read -rsp $"\nPress any key to continue.."
;;
6)
	echo "6. Cambiar nombre de la rama principal de Master a main"
	git branch -M main
	read -rsp $"\nPress any key to continue.."
;;
7)
	echo "7. Subir repositorio a remoto"
	git push -u -f $ruta
	read -rsp $"\nPress any key to continue.."
;;
8)
	echo "8. Salir"
	echo "Gracias por su visita"
	read -rsp $"\nPress any key to continue.."
	$salir="S"
	#exit
;;
*)
	echo "Opcion incorrecta";;
	esac
clear
done