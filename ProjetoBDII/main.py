from pymongo import MongoClient
from Clientes import ClientesModel
from datetime import datetime

# conexão com o banco
client = MongoClient("mongodb://localhost:27017/")
db = client["BancoFocus"]
clientes_model = ClientesModel(db)

def menu():
    print("---------- MENU -----------")
    print("1-> Cadastrar")
    print("2-> Buscar cadastro")
    print("3-> Atualizar cadastro")
    print("4-> Processo Finalizado")
    print("6-> Clientes do mês")
    print("7-> Sair")

while True:
    menu()
    opcao = input("Escolha uma opção: ")

    if opcao == "1":
        nome = input("Nome: ")
        email = input("Email: ")
        telefone = input("Telefone: ")
        try:
            dia = int(input("Dia da entrevista (dd): "))
            mes = int(input("Mês da entrevista (mm): "))
            hora = int(input("Hora da entrevista (24h): "))
            data_entrevista = datetime(2025, mes, dia, hora, 0)
            clientes_model.create_cliente(nome, email, telefone, data_entrevista)
        except Exception as e:
            print("Erro ao registrar data. Certifique-se de usar números válidos.")

    elif opcao == "2":
        nome_cliente = input("Nome completo: ")
        clientes_model.read_cliente_by_nome(nome_cliente)

    elif opcao == "3":
        id_cliente = input("ID para atualizar: ")
        campo = input("Qual campo deseja atualizar? (nome, email, telefone, data): ").lower()
        if campo == "data":
            try:
                dia = int(input("Novo dia: "))
                mes = int(input("Novo mês: "))
                hora = int(input("Nova hora: "))
                nova_data = datetime(2025, mes, dia, hora, 0)
                clientes_model.update_cliente(id_cliente, {"data_entrevista": nova_data})
            except:
                print("Data inválida.")
        elif campo in ["email", "telefone"]:
            novo_valor = input(f"Novo valor para {campo}: ")
            clientes_model.update_cliente(id_cliente, {campo: novo_valor})
        elif campo == "nome":
            novo_valor = input(f"Novo valor para {campo}: ")
            clientes_model.update_cliente(id_cliente, {"nome": novo_valor})
        else:
            print("Campo inválido.")

    elif opcao == "4":
        id_cliente = input("ID para deletar: ")
        clientes_model.delete_cliente(id_cliente)

    elif opcao == "6":
        try:
            ano = int(input("Digite o ano (ex: 2025): "))
            mes = int(input("Digite o mês (1-12): "))
            clientes_model.read_clientes_por_mes(ano, mes)
        except ValueError:
            print("Ano e mês devem ser números inteiros.")

    elif opcao == "7":
        print("Encerrando o programa.")
        break

    else:
        print("Opção inválida.")