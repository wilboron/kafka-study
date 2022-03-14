docker-compose up -d
docker exec broker kafka-topics --bootstrap-server broker:9092 --create --topic payment_request
docker exec broker kafka-topics --bootstrap-server broker:9092 --create --topic payment_authorization
docker exec broker kafka-topics --bootstrap-server broker:9092 --create --topic payment_process
