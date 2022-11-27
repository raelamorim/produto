URL = "http://localhost:4566"

import boto3

dynamodb = boto3.resource("dynamodb", region_name="sa-east-1", endpoint_url=URL)
table = dynamodb.Table('produto-table')

# table.delete_item(
#     Key={
#         "id_produto": 1
#     }
# )

table.put_item(Item={
    "id_produto": 1,
    "nome_produto": "Previdencia First",
    "encerrado": False,
    "id_risco": 1,
    "segmentos": [
        "1",
        "2",
        "3"
    ],
    "canais_operacoes": [
        {
            "id_canal": 1,
            "id_operacao": 1
        },
        {
            "id_canal": 1,
            "id_operacao": 2
        },
        {
            "id_canal": 2,
            "id_operacao": 2
        }
    ]
})