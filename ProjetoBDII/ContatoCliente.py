class ContatoCliente:
    def __init__(self, email: str, telefone: str):
        self.email = email
        self.telefone = telefone

    def __str__(self):
        return f"Email: {self.email}, Telefone: {self.telefone}"