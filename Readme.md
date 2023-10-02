# Search Words

The objective of this program is search words that match with the search criteria.

# Search Criteria

- length: Size of the word.
- letterPositions (optional): The letter have to be in a determinant position.
- letterTotals (optional): Exact total letter in the word

# Curl example
`
curl --location 'http://localhost:8080/word' \
--header 'Content-Type: application/json' \
--data '{
"letters":"zapatoso",
"length":6,
"letterPositions":[
{
"letter":"z",
"position":0
}
],
"letterTotals":[
{
"letter":"o",
"total":1
},
{
"letter":"z",
"total":1
}
]
}'
`