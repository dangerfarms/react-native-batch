require 'json'

package = JSON.parse(File.read(File.join(__dir__, 'package.json')))

Pod::Spec.new do |s|
  s.name         = package['name']
  s.version      = package['version']
  s.license      = { :type => 'MIT' }
  s.homepage     = package['homepage']
  s.author       = { 'Benoit VALLON' => 'benoitvallon@gmail.com' }
  s.summary      = package['description']
  s.source       = { :git => package['repository']['url'] }
  s.source_files = "ios/*.{h,m}"
  s.platform     = :ios, "10.0"
  s.frameworks   = [ "Batch" ]
  s.static_framework = true
  s.dependency 'React'
  s.dependency 'Batch'
end
