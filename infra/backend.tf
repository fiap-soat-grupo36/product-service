terraform {
  backend "s3" {
    bucket = "fiap-fase-4-oficina"
    key    = "product-service/terraform.tfstate"
    region = "us-east-1"
  }
}
