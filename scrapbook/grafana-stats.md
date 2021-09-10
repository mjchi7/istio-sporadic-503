sum(rate(istio_requests_total{destination_service_name="synchronous"}[2m])) by (response_code, response_flags, destination_service_name, reporter)

{{reporter}}_{{destination_service_name}}-{{response_code}}, {{response_flags}}