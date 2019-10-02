
Pod::Spec.new do |s|
  s.name         = "RNBatch"
  s.version      = "1.0.0"
  s.summary      = "RNBatch"
  s.description  = <<-DESC
                  RNBatch
                   DESC
  s.homepage     = "https://github.com/heappi/react-native-batch"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/author/RNBatch.git", :tag => "master" }
  s.source_files  = "RNBatch/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end

  
