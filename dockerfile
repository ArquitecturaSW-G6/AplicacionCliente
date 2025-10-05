FROM ruby:3.2.9

RUN echo "require 'logger'" > /usr/local/lib/ruby/3.2.0/logger_fix.rb
ENV RUBYOPT='-r/usr/local/lib/ruby/3.2.0/logger_fix.rb'

WORKDIR /app
COPY . .
RUN bundle install
EXPOSE 3000
CMD ["rails", "server", "-b", "0.0.0.0", "-p", "3000"]
