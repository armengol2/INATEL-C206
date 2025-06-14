import time
from Clientes import ClientesModel
from pymongo import MongoClient

if __name__ == "__main__":
    client = MongoClient("mongodb://localhost:27017/")
    db = client["BancoFocus"]
    modelo = ClientesModel(db)
    try:
        while True:
            modelo.avisar_entrevistas_atuais()
            time.sleep(60)
    except KeyboardInterrupt:
        print("Monitor de entrevistas finalizado pelo usuário.")