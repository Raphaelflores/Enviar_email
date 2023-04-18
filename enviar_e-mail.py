import win32com.client as win32

outlook = win32.Dispatch('outlook.aplication')

email = outlook.CreateItem(0)

email.To = "Destinatario"
email.Subject = "assunto"
email.HTMLBody = """    <p>Corpo do e-mail em HTML</p> 
"""

anexo = "c://Users/Realionamento/downloads/arquivo.xlsx"
email.Attachments.Add(anexo)

email.Send()
print ("E-mail enviado")